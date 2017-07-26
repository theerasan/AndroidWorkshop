package ta.com.workshop2

import android.content.Context
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView



class ImageRatioView : ImageView {

    var imageOrientation: Int? = 0
    var imageRatio: Int? = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, @Nullable attrs: AttributeSet) : this(context, attrs, 0)

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ImageRatioView, defStyleAttr, defStyleRes)
        imageOrientation = a.getInt(R.styleable.ImageRatioView_imageOrientation, 0)
        imageRatio = a.getInt(R.styleable.ImageRatioView_imageRatio, 0)

        a.recycle()
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        var width =  MeasureSpec.getSize(widthMeasureSpec)
        var height = MeasureSpec.getSize(heightMeasureSpec)

        when(imageOrientation) {
            0 -> {
                height = calculateRatio(width)
            }
            1 -> {
                width = calculateRatio(height)
            }
        }

        this.setMeasuredDimension(width, height)
        this.layoutParams.width = width
        this.layoutParams.height = height
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    private fun calculateRatio(measureSpec: Int) : Int {
        return when (imageRatio) {
            0 -> measureSpec
            1 -> measureSpec * (1/2)
            else -> {
                0
            }
        }
    }
}