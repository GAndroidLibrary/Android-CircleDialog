package com.mylhyl.circledialog.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mylhyl.circledialog.BuildView;
import com.mylhyl.circledialog.CircleParams;
import com.mylhyl.circledialog.view.listener.ButtonView;

/**
 * view的层次结构
 * <pre>
 * CardView
 *    ╚--LinearLayout
 *           ┗--TitleView
 *           ┗--BodyView
 *           ┗--ButtonView
 * </pre>
 * Created by hupei on 2017/3/29.
 */

abstract class BuildViewAbs implements BuildView {
    protected Context mContext;
    protected CircleParams mParams;
    protected ViewGroup mRoot;
    private LinearLayout mRootCardViewByLinearLayout;
    private ButtonView mButtonView;

    public BuildViewAbs(Context context, CircleParams params) {
        this.mContext = context;
        this.mParams = params;
    }

    protected final void buildTitleView() {
        if (mParams.titleParams != null) {
            TitleView titleView = new TitleView(mContext, mParams.dialogParams
                    , mParams.titleParams, mParams.subTitleParams, mParams.createTitleListener);
            addViewByBody(titleView);
        }
    }

    protected final void addViewByBody(View child) {
        mRootCardViewByLinearLayout.addView(child);
    }

    protected final View layoutInflaterFrom(int resource) {
        return LayoutInflater.from(mContext)
                .inflate(resource, mRootCardViewByLinearLayout, false);
    }

    protected void buildRootView() {
        CardView cardView = buildCardView();
        buildLinearLayout();
        cardView.addView(mRootCardViewByLinearLayout);
        mRoot = cardView;
    }

    protected CardView buildCardView() {
        CardView cardView = new CardView(mContext);
        cardView.setCardElevation(0f);
        cardView.setCardBackgroundColor(Color.TRANSPARENT);
        cardView.setRadius(mParams.dialogParams.radius);
        return cardView;
    }

    protected LinearLayout buildLinearLayout() {
        mRootCardViewByLinearLayout = new LinearLayout(mContext);
        mRootCardViewByLinearLayout.setOrientation(LinearLayout.VERTICAL);
        return mRootCardViewByLinearLayout;
    }

    @Override
    public final View getRootView() {
        return mRoot;
    }

    @Override
    public ButtonView buildButton() {
        if (mButtonView == null) {
            mButtonView = new MultipleButton(mContext, mParams.dialogParams, mParams.negativeParams
                    , mParams.positiveParams, mParams.neutralParams, mParams.createButtonListener);
            if (!mButtonView.isEmpty()) {
                DividerView dividerView = new DividerView(mContext, LinearLayout.HORIZONTAL);
                addViewByBody(dividerView);
            }
        }
        if (mButtonView != null) {
            addViewByBody(mButtonView.getView());
        }
        return mButtonView;
    }

    @Override
    public final void refreshButton() {
        if (mButtonView != null) {
            mButtonView.refreshText();
        }
    }
}
