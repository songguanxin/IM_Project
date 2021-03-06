package com.lib_im.pro.ui.widget.swipe;


import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 不显示，只用于边缘滚动的Footer
 */
public class ParallaxFooter extends View implements SwipeView {
  private float mHeight;

  public ParallaxFooter(Context context) {
    super(context);
  }

  public ParallaxFooter(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  public void setRefreshing() {

  }

  @Override
  public void setNormal() {

  }

  @Override
  public void setPulling() {

  }

  @Override
  public void setComplete() {

  }

  @Override
  public void setFailed() {

  }

  @Override
  public float scrollOffset(float totalHeight, int offset) {
    double exp = Math.exp(-(mHeight / 400));
//        double exp = 0.5;
    double v = -offset * exp;
    setHeadHeight((int) (Math.max(mHeight + v, 0)));
    return mHeight;
  }

  @Override
  public void setOnRefreshListener(OnRequestListener listener) {

  }

  @Override
  public boolean isRefreshing() {
    return false;
  }

  @Override
  public void stopScroll(float totalUnconsumed) {
    ValueAnimator hideAnimator;
    hideAnimator = ValueAnimator.ofFloat();
    hideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        setHeadHeight((float) animation.getAnimatedValue());
      }
    });
    hideAnimator.addListener(new AnimatorListenerAdapter() {
    });
    hideAnimator.setFloatValues(mHeight, 0F);
    hideAnimator.start();
  }

  @Override
  public void setCanRequest(boolean canLoadMore) {

  }


  private void setHeadHeight(float height) {
    mHeight = height;
    ViewGroup.LayoutParams params = getLayoutParams();
    if (params == null) {
      params = getLayoutParams();
    }
    params.height = (int) mHeight;
    setLayoutParams(params);
    ((LSwipeRefreshLayout) getParent()).changeTargetY(-mHeight);
  }
}
