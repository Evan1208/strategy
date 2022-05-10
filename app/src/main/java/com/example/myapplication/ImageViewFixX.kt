package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import kotlin.math.roundToInt

@SuppressLint("AppCompatCustomView")
class ImageViewFixX(context: Context?, attrs: AttributeSet?) : ImageView(context, attrs) {

    private var mMatrix = Matrix()
    private var mDrawMatrix : Matrix ?= null
    private var mDrawable: Drawable? = null
    private var mDrawableWidth = 0
    private var mDrawableHeight = 0


    override fun setFrame(l: Int, t: Int, r: Int, b: Int): Boolean {
        val iBoolean =  super.setFrame(l, t, r, b)
        mDrawMatrix = mMatrix;
        if (mDrawable == null) {
            return iBoolean
        }

        // 使用最簡單的方式, xml的高度多少將不影響內不需顯示的大小, 須注意使用
        val iR = resources
        val iDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320.0f, iR.displayMetrics)
            .roundToInt()
        mDrawable?.setBounds(0, 0, width, iDp)
        // 將centercrop的改寫為0, 0為主, 但因為寬度問題, 可能導致某些頁面出現問題
//        mDrawMatrix?.let {
//            val dwidth = mDrawableWidth
//            val dheight = mDrawableHeight
//            val vwidth: Int = width
//            val vheight: Int = height
//            val dx = 0
//            val dy = 0
//            val scale = if (dwidth * vheight > vwidth * dheight) {
//                 vheight.toFloat() /  dheight.toFloat()
//            } else {
//                 vwidth.toFloat() /  dwidth.toFloat()
//            }
//            it.setScale(scale, scale)
//            it.postTranslate(dx.toFloat().roundToInt().toFloat(), dy.toFloat().roundToInt().toFloat())
//
//            /* If the drawable has no intrinsic size, or we're told to
//                scaletofit, then we just fill our entire view.
//            */
////            mDrawMatrix = null
//        }

        return iBoolean
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        mDrawable = drawable
    }

    override fun invalidateDrawable(dr: Drawable) {
        super.invalidateDrawable(dr)
        if (dr == mDrawable) {
            // update cached drawable dimensions if they've changed
            val w = dr.intrinsicWidth
            val h = dr.intrinsicHeight
            if (w != mDrawableWidth || h != mDrawableHeight) {
                mDrawableWidth = w
                mDrawableHeight = h
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            val saveCount = it.saveCount
            if (mDrawMatrix != null) {
                it.concat(mDrawMatrix)
            }
            mDrawable?.draw(it)
            it.restoreToCount(saveCount)
        }
    }
}