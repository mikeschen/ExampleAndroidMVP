package com.mikeschen.www.todoandroidmvp;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;

public interface MVP_Main {
    interface RequiredViewOps {
        Context getAppContext();
        Context getActivityContext();
        void notifyItemInserted(int layoutPosition);
        void notifyItemRangeChanged(int positionStart, int itemCount);
    }

    interface ProvidedPresenterOps {
        void clickNewNote(EditText editText);
        int getNotesCount();
        NotesViewHolder createViewHolder(ViewGroup parent, int viewType);
        void bindViewHolder(NotesViewHolder holder, int position);
    }

    interface RequiredPresenterOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedModelOps {
        int getNotesCount();
        Note getNote(int position);
        int insertNote(Note note);
        boolean loadData();
    }
}
