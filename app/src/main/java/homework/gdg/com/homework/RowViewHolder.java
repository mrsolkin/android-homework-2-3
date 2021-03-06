package homework.gdg.com.homework;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class RowViewHolder extends RecyclerView.ViewHolder {

    private TextView mCountryView;
    private TextView mCapitalView;
    private TextView mLikesCountView;
    private Button mLikeBtn;
    private Button mDislikeBtn;

    RowViewHolder(View itemView) {
        super(itemView);
        mCountryView = (TextView) itemView.findViewById(R.id.country);
        mCapitalView = (TextView) itemView.findViewById(R.id.capital);
        mLikesCountView = (TextView) itemView.findViewById(R.id.likes_label);
        mLikeBtn = (Button) itemView.findViewById(R.id.like);
        mDislikeBtn = (Button) itemView.findViewById(R.id.dislike);
    }

    @SuppressLint("DefaultLocale")
    void bind(final RowModel model, final Adapter.OnUpdateListener listener) {


        mCountryView.setText(model.getCountry());
        mCapitalView.setText(model.getCapital());
        mLikesCountView.setText(String.format("Нравится: %d", model.getLikes()));

        mLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.like();
                listener.updatePosition(getAdapterPosition());
            }
        });
        mDislikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.dislike();
                listener.updatePosition(getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                model.setIsSelected(!model.isSelected());
                listener.updatePosition(getAdapterPosition());
                return false;
            }
        });
    }
}
