package com.nlpsample.adapters;

public class NLMatchRecyclerAdapter{ // extends RecyclerView.Adapter<AllergyRecyclerAdapter.AllergyViewHolder> {

//    private List<PatientAllergy> dataList;
//    private FragmentActivity mContext;
//    private String TYPE_IN_ACTIVE = "inactive";
//    private View.OnLongClickListener longClickListener;
//
//    public void setLongClickListener(View.OnLongClickListener listener) {
//        longClickListener = listener;
//    }
//
//    public class AllergyViewHolder extends RecyclerView.ViewHolder {
//        ImageView imgAllergyComments;
//        LinearLayout llParentView;
//        TextView tvAllergyName, tvAllergyType, tvAllergyReaction, tvAllergySeverity, tvOnSetDate,
//                tvUpdate, tvInactiveReason, tvInactiveComments;
//
//        public AllergyViewHolder(View view) {
//            super(view);
//            imgAllergyComments = (ImageView) view.findViewById(R.id.imgComments);
//            tvAllergyName = (TextView) view.findViewById(R.id.tvAllergenName);
//            tvAllergyType = (TextView) view.findViewById(R.id.tvAllergenType);
//            tvInactiveReason = (TextView) view.findViewById(R.id.textViewInactiveReason);
//            tvInactiveComments = (TextView) view.findViewById(R.id.textViewInactiveComments);
//
//            tvAllergyReaction = (TextView) view.findViewById(R.id.tvReaction);
//            tvAllergySeverity = (TextView) view.findViewById(R.id.tvSeverity);
//            tvOnSetDate = (TextView) view.findViewById(R.id.tvOnSet);
//            tvUpdate = (TextView) view.findViewById(R.id.tvUpdatedDate);
//            llParentView = (LinearLayout) view.findViewById(R.id.allergyParentItem);
//        }
//    }
//
//    public NLMatchRecyclerAdapter(FragmentActivity activity, List<PatientAllergy> data) {
//        this.dataList = data;
//        mContext = activity;
//    }
//
//    @Override
//    public AllergyRecyclerAdapter.AllergyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutUtil.getLayoutInflater(mContext)
//                .inflate(R.layout.allergy_list_item, parent, false);
//        return new AllergyRecyclerAdapter.AllergyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(AllergyRecyclerAdapter.AllergyViewHolder holder, final int position) {
//        final PatientAllergy dto = dataList.get(position);
//        holder.tvAllergyName.setText(TextUtils.makeFirstLetterCapital(dto.name));
//        holder.tvAllergyType.setText(dto.allergenType);
//
//        String capitalAllergyType = TextUtils.makeFirstLetterCapital(TextUtils.getFormatText(dto.allergenType));
//        holder.tvAllergyType.setText(TextUtils.getDifferentFontText("Allergen Type: ", capitalAllergyType));
//        holder.tvAllergyReaction.setText(TextUtils.getDifferentFontText("Reaction: ", TextUtils.getFormatText(dto.reaction)));
//
//        String capitalSeverity = TextUtils.makeFirstLetterCapital(TextUtils.getFormatText(dto.severity));
//        holder.tvAllergySeverity.setText(TextUtils.getDifferentFontTextWithColor("Severity: ", capitalSeverity, getSeverityTextColor(capitalSeverity)));
//
//        holder.tvOnSetDate.setVisibility(View.GONE);
//        if (dto.onsetDate != null) {
//            String onSetDate = DateTimeUtil.getFormattedDate(Constants.SERVER_DATE_FORMAT, Constants.DISPLAY_DATE_FORMAT, dto.onsetDate);
//            if (!onSetDate.isEmpty()) {
//                holder.tvOnSetDate.setVisibility(View.VISIBLE);
//                holder.tvOnSetDate.setText(TextUtils.getDifferentFontText("Onset: ", onSetDate));
//            }
//        }
//        holder.tvUpdate.setVisibility(View.GONE);
//        if (dto.updated != null) {
//            String updateDate = DateTimeUtil.getFormattedDate(Constants.SERVER_TIME_FORMAT_SS, Constants.DISPLAY_DATE_FORMAT, dto.updated);
//            if (!updateDate.isEmpty()) {
//                holder.tvUpdate.setVisibility(View.VISIBLE);
//                holder.tvUpdate.setText(TextUtils.getDifferentFontText("Updated: ", TextUtils.getFormatText(updateDate)));
//            }
//        }
//        if (longClickListener != null) {
//            holder.itemView.setTag(dto);
//            holder.itemView.setOnLongClickListener(longClickListener);
//        }
//        // Inactive Reason and Comments
//        if (dto.inactiveReason != null && !dto.inactiveReason.isEmpty()) {
//            holder.tvInactiveReason.setVisibility(View.VISIBLE);
//            holder.tvInactiveReason.setText(TextUtils.getDifferentFontText("Inactive Reason: ", TextUtils.getFormatText(dto.inactiveReason)));
//        } else {
//            holder.tvInactiveReason.setVisibility(View.GONE);
//        }
//
//        // If Status Type is in active show reason and comments
//        if (dto.statusType != null && dto.statusType.equalsIgnoreCase(TYPE_IN_ACTIVE)) {
//            holder.tvInactiveReason.setVisibility(View.VISIBLE);
//            holder.tvInactiveComments.setVisibility(View.VISIBLE);
//        } else {
//            holder.tvInactiveReason.setVisibility(View.GONE);
//            holder.tvInactiveComments.setVisibility(View.GONE);
//        }
//
//        if (dto.inactiveComments != null && !dto.inactiveComments.isEmpty()) {
//            holder.tvInactiveComments.setVisibility(View.VISIBLE);
//            holder.tvInactiveComments.setText(TextUtils.getDifferentFontText("Inactive Comments: ", TextUtils.getFormatText(dto.inactiveComments)));
//        } else {
//            holder.tvInactiveComments.setVisibility(View.GONE);
//        }
//        TextUtils.setCommentsView(mContext, holder.imgAllergyComments, dto.comments, false);
//    }
//
//    @Override
//    public int getItemCount() {
//        return AdapterUtil.getItemCount(dataList);
//    }
//
//    /**
//     * @param title
//     * @return
//     */
//    private String getSeverityTextColor(String title) {
//        if (title.equalsIgnoreCase("Unspecified Severity") || title.equalsIgnoreCase("Severe Persistent")) {
//            return Constants.COLOR_RED;
//        } else if (title.equalsIgnoreCase("Moderate Persistent")) {
//            return Constants.COLOR_ORANGE;
//        } else if (title.equalsIgnoreCase("Mild Persistent") || title.equalsIgnoreCase("Mild Intermittent")) {
//            return Constants.COLOR_GREEN;
//        } else {
//            return Constants.COLOR_NORMAL;
//        }
//    }
}
