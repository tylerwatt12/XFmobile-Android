package com.iblazeapp;


import android.app.*;
import android.content.*;
import android.view.*;
import android.view.animation.*;

/**
 * AnimationUtils is a helper class to make it easy to apply certain animation effects to layouts and components.
 * It also demonstrates various ways of loading animation sequence definitions - from XML and generated in Java code.
 *
 * @author Nazmul Idris
 * @version 1.0
 * @since Jun 24, 2008, 1:22:27 PM
 */
public class AnimUtils {

/* @see <a href="http://code.google.com/android/samples/ApiDemos/src/com/google/android/samples/view/LayoutAnimation2.html">animations</a> */
public static void setLayoutAnim_slidedownfromtop(ViewGroup panel, Context ctx) {

  AnimationSet set = new AnimationSet(true);

  Animation animation = new AlphaAnimation(0.0f, 1.0f);
  animation.setDuration(100);
  set.addAnimation(animation);

  animation = new TranslateAnimation(
      Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
      Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f
  );
  animation.setDuration(500);
  set.addAnimation(animation);

  LayoutAnimationController controller =
      new LayoutAnimationController(set, 0.25f);
  panel.setLayoutAnimation(controller);

}


/** load a layout animation sequence from xml */
public static void setLayoutAnimation2(ViewGroup panel, Context ctx) {

  //LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(ctx, R.anim.app_enter);

  //panel.setLayoutAnimation(controller);

}

public static void setLayoutAnim_slideupfrombottom(ViewGroup panel, Context ctx) {

  AnimationSet set = new AnimationSet(true);

  Animation animation = new AlphaAnimation(0.0f, 1.0f);
  animation.setDuration(100);
  set.addAnimation(animation);

  animation = new TranslateAnimation(
      Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
      Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f
  );
  animation.setDuration(500);
  set.addAnimation(animation);

//  set.setFillBefore(false);
//  set.setFillAfter(false);

  LayoutAnimationController controller =
      new LayoutAnimationController(set, 0.25f);
  panel.setLayoutAnimation(controller);

}

public static Animation runFadeOutAnimationOn(Activity ctx, View target) {
  Animation animation = AnimationUtils.loadAnimation(ctx,
                                                     android.R.anim.fade_out);
  target.startAnimation(animation);
  return animation;
}

}//end class AnimationUtils
