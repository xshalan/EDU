package com.example.myapplication.ui.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.myapplication.R;
import com.example.myapplication.data.model.LessonModel;
import com.example.myapplication.data.database.LessonsDatabase;
import com.example.myapplication.data.dao.LessonsDAO;
import com.example.myapplication.utils.DatabaseInit;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog;
import com.shreyaspatil.MaterialDialog.interfaces.DialogInterface;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class PdfFragment extends Fragment {

    private PDFView pdfView ;
    private KonfettiView konfettiView;


    private Bundle arguments;
    private LessonModel lesson;

    private LessonsDAO lessonsDAO;

    private SharedPreferences sharedPreferences;

    int prgress = 0 ;
    public PdfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pdf, container, false);
        konfettiView = view.findViewById(R.id.viewKonfetti);
        sharedPreferences = getActivity().getSharedPreferences("com.example.myapplication",MODE_PRIVATE);
        lessonsDAO = LessonsDatabase.getInstance(getContext()).lessonsDAO();
        pdfView =  view.findViewById(R.id.pdfView);
        arguments = getArguments();
        lesson = (LessonModel) arguments.getSerializable("lesson");
        Log.d("PDF",lesson.getTitle());

        pdfView.fromAsset("pdf/ch1.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(true)
                .pageSnap(true)
                .autoSpacing(true)
                .pageFling(true)
                .enableAnnotationRendering(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAntialiasing(true)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        Log.d("PDF",page + "  --> count:  " + pageCount);
                        if(page == pageCount-1){
                            showKonfetti(konfettiView);

                            //pdfView.setSwipeEnabled(false);

                            BottomSheetMaterialDialog mBottomSheetDialog = new BottomSheetMaterialDialog.Builder((AppCompatActivity) getActivity())

                                    .setTitle(getActivity().getString(R.string.lesson_complete_message_title))
                                    .setMessage(getActivity().getString(R.string.lesson_complete_message))
                                    .setCancelable(false)

                                    .setPositiveButton(getActivity().getString(R.string.next_lesson), new BottomSheetMaterialDialog.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int which) {
                                            Toast.makeText(getContext(), "Deleted!", Toast.LENGTH_SHORT).show();
                                            dialogInterface.dismiss();
                                        }
                                    })
                                    .setNegativeButton(getActivity().getString(R.string.home), new BottomSheetMaterialDialog.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int which) {
                                            Toast.makeText(getContext(), "Cancelled!", Toast.LENGTH_SHORT).show();
                                            dialogInterface.dismiss();
                                        }
                                    })
                                    .setAnimation("checked-done.json")
                                    .build();

                            // Show Dialog
                            LottieAnimationView animationView = mBottomSheetDialog.getAnimationView();
                            animationView.setRepeatCount(1);


                            mBottomSheetDialog.show();
                            lessonsDAO.updateOpenByLessonId(true,lesson.getId()+1);
                            lessonsDAO.updateProgressableByLessonId(true,lesson.getId()+1);
                            lessonsDAO.updateDoneByLessonId(true,lesson.getId());
                            lessonsDAO.updateProgressableByLessonId(false,lesson.getId());
                            int newScore = DatabaseInit.calculateProgress(lesson.getId());
                            sharedPreferences.edit().putInt(DatabaseInit.OVERALL_PROGRESS_KEY,newScore).apply();
                            Log.d("PdfFRagment", "progress ->" + newScore);
                        }else{

                            prgress = 100*page;
                            prgress /=pageCount;
                            Log.d("PdfFRagment","id -->" + lesson.getId() + "progress ->" + prgress);
                            lessonsDAO.updateProgressByLessonId(prgress,lesson.getId());
                        }
                    }
                })



                .load();
        return view;
    }

    public void showKonfetti(KonfettiView konfettiView){
        konfettiView.build()
                .addColors(ContextCompat.getColor(getContext(),R.color.colorAccent)
                        , ContextCompat.getColor(getContext(),R.color.darkBlue)
                        , ContextCompat.getColor(getContext(),R.color.lightGreen))
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.RECT, Shape.CIRCLE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
