package com.thomaz.testcapptan.adapter;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thomaz.testcapptan.data.IAdapter;

import java.util.List;

/**
 * Created by thomaz on 02/01/19.
 */
public class ScheduleAdapter<TPI extends IAdapter>
        extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    static public final int CATEGORY_TYPE = 0;
    static public final int PRODUCT_TYPE = 1;
    static public final int ITEM_CATEGORY_TYPE = 2;
    static public final int VOUCHER_TYPE = 3;
    static public final int NONE_TO_SHOW_TYPE = 4;

    private Context context;
    private Activity activity;

    public List<TPI> tpis;

    public ScheduleAdapter(List<TPI> tpis) {
        this.tpis = tpis;
    }

    public ScheduleAdapter(List<TPI> tpis, Activity activity) {
        this.tpis = tpis;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

//        switch (viewType) {
//            case CATEGORY_TYPE :
//                return new ViewHolder((LineFeedCategoriesBinding) DataBindingUtil
//                        .inflate(inflater, R.layout.line_feed_categories, parent, false));
//            case PRODUCT_TYPE:
//                return new ViewHolder((LineFeedProductBinding) DataBindingUtil
//                        .inflate(inflater, R.layout.line_feed_product, parent, false));
//            case ITEM_CATEGORY_TYPE:
//                return new ViewHolder((LineSearcherBinding) DataBindingUtil
//                        .inflate(inflater, R.layout.line_searcher, parent, false));
//            case VOUCHER_TYPE:
//                return new ViewHolder((LineVoucherBinding) DataBindingUtil
//                        .inflate(inflater, R.layout.line_voucher, parent, false));
//            case NONE_TO_SHOW_TYPE:
//                return new ViewHolder((LineNoneToShowBinding) DataBindingUtil
//                        .inflate(inflater, R.layout.line_none_to_show, parent, false));
//        }
        return null;
    }

    @Override
    public int getItemCount() {
        return tpis.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder holder, int position) {

        TPI tpi = tpis.get(position);

//        if (tpi != null) {
//            switch (tpi.getType()) {
//                case CATEGORY_TYPE :
//                    CategoriesDataView dataView = (CategoriesDataView) tpi;
//
//                    FeedControllerAdapter adapter = new FeedControllerAdapter<>(dataView.categoriesDataViews);
//
//                    LinearLayoutManager layoutManager
//                            = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//                    holder.categoriesBinding.rvCategories.setLayoutManager(layoutManager);
//                    holder.categoriesBinding.rvCategories.setHasFixedSize(true);
//                    holder.categoriesBinding.rvCategories.setAdapter(adapter);
//
//                    break;
//                case PRODUCT_TYPE :
//                    Product product = (Product) tpi;
//                    holder.productBinding.setProduct(product);
//
//                    if( product.image != null ) {
//                        PicassoTrustAll.getInstance(context).load(product.image.origin).into(holder.productBinding.ivProduct);
//                    }
//
//                    holder.productBinding.price.setText(product.getPriceFormatted());
//
//                    holder.productBinding.ibFavorite.setImageResource(product.wishlist ?
//                            R.mipmap.ic_like_card_favorited : R.mipmap.ic_like_card);
//
//                    product.favoriteClick = () -> {
//
//                        boolean itsConnected = Hawk.contains(Constants.USER_HAWK);
//
//                        if( itsConnected ) {
//                            new BaseFavoriteApi.Post(activity, product.id) {
//                                @Override
//                                public void onSuccess(Response<Void> response) {
//                                    product.wishlist = !product.wishlist;
//                                    notifyItemChanged(position);
//                                }
//                            };
//                        } else {
//                            activity.startActivityForResult(new Intent(activity, LoginActivity.class), Constants.REQUEST_UPDATE);
//                        }
//                    };
//
//                    holder.productBinding.getRoot().setOnClickListener(view -> {
//                        Intent intent = new Intent(context, DetailVoucherActivity.class);
//                        intent.putExtra(DetailVoucherActivity.PRODUCT, product);
//
//                        activity.startActivityForResult(intent, Constants.REQUEST_UPDATE);
//                    });
//
//                    break;
//                case ITEM_CATEGORY_TYPE :
//                    Category category = (Category) tpi;
//
//                    holder.searcherBinding.setCategory(category);
//
//                    if( category.image != null ) {
//                        PicassoTrustAll.getInstance(context).load(category.image.origin).into(holder.searcherBinding.ivSearch);
//                    } else if( category.imageBitmap > 0 ) {
//                        Picasso.get().load(category.imageBitmap).into(holder.searcherBinding.ivSearch);
//                    }
//
//                    holder.searcherBinding.getRoot().setOnClickListener(view -> {
//                        if ( category.kindLine == Category.StaticKindLine.VER_NO_MAPA ) {
//                            activity.startActivity(new Intent(activity, MapsActivity.class));
//                        } else {
//
//                        }
//                    });
//
//                    break;
//
//                case VOUCHER_TYPE :
//
//                    Voucher voucher = (Voucher) tpi;
//
//                    holder.voucherBinding.setVoucher(voucher);
//
//                    if( voucher.product.establishment.image != null ) {
//                        PicassoTrustAll.getInstance(context).load(voucher.product.establishment.image.thumb).into(holder.voucherBinding.ivEstablishment);
//                    }
//
//                    if( voucher.product.image != null ) {
//                        PicassoTrustAll.getInstance(context).load(voucher.product.image.thumb).into(holder.voucherBinding.ivProduct);
//                    }
//
//                    holder.voucherBinding.btAvaliate.setOnClickListener(view -> {
//                        final String CHOOSE_DEVICE = "CHOOSE_DEVICE";
//
//                        FragmentManager fm = activity.getFragmentManager();
//                        AvaliateVoucher fragment = new AvaliateVoucher();
//                        fragment.setRefreshLine(FeedControllerAdapter.this);
//                        fragment.setNumRow(position);
//                        fragment.setVoucher(voucher);
//
//                        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);
//
//                        fragment.show(fm, CHOOSE_DEVICE);
//
//                    });
//
//                    holder.voucherBinding.btOpenVoucher.setOnClickListener(view -> {
//                        Intent intent = new Intent(activity, VoucherActivity.class);
//                        intent.putExtra(VoucherActivity.VOUCHER, voucher);
//
//                        activity.startActivityForResult(intent, Constants.REQUEST_UPDATE);
//                    });
//
//                    break;
//                case NONE_TO_SHOW_TYPE :
//                    NoneToShowDataView toShowDataView = (NoneToShowDataView) tpi;
//
//                    holder.noneToShowBinding.tvTitleListEmpty.setText(toShowDataView.message);
//                    break;
//            }
//        }
    }

    @Override
    public int getItemViewType(int position) {
        if (tpis != null) {
            IAdapter object = tpis.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return -1;
    }

    public void add(List<TPI> items) {
        int previousDataSize = tpis.size();
        tpis.addAll(items);
        notifyItemRangeInserted(previousDataSize, items.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


}

