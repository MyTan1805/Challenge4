package com.project.challenge4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 1. Định nghĩa các hằng số cho từng loại View
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private List<Sport> sportsList;

    public SportsAdapter(List<Sport> sportsList) {
        this.sportsList = sportsList;
    }

    // 2. Tạo một ViewHolder riêng cho Header
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView headerImageView;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerImageView = itemView.findViewById(R.id.headerImageView);
        }
    }

    // ViewHolder cho các mục thể thao vẫn giữ nguyên
    public static class SportViewHolder extends RecyclerView.ViewHolder {
        ImageView sportImageView;
        TextView sportNameTextView;

        public SportViewHolder(@NonNull View itemView) {
            super(itemView);
            sportImageView = itemView.findViewById(R.id.sportImageView);
            sportNameTextView = itemView.findViewById(R.id.sportNameTextView);
        }
    }

    // 3. Override phương thức getItemViewType
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_HEADER; // Vị trí đầu tiên là header
        } else {
            return VIEW_TYPE_ITEM; // Các vị trí còn lại là item
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 4. Tạo ViewHolder tương ứng với viewType
        if (viewType == VIEW_TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new HeaderViewHolder(view);
        } else { // VIEW_TYPE_ITEM
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sport, parent, false);
            return new SportViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // 5. Gán dữ liệu dựa trên loại ViewHolder
        if (holder.getItemViewType() == VIEW_TYPE_ITEM) {
            // Đây là SportViewHolder
            SportViewHolder sportHolder = (SportViewHolder) holder;
            // Dữ liệu sport sẽ bắt đầu từ vị trí 1 trong adapter, tương ứng với vị trí 0 trong list
            Sport currentSport = sportsList.get(position - 1);
            sportHolder.sportNameTextView.setText(currentSport.getName());
            sportHolder.sportImageView.setImageResource(currentSport.getImageResourceId());
        }
        // Với HeaderViewHolder, chúng ta không cần làm gì cả vì ảnh đã được set trong XML
    }

    @Override
    public int getItemCount() {
        // 6. Tổng số item = số sport + 1 (cho header)
        return sportsList.size() + 1;
    }
}