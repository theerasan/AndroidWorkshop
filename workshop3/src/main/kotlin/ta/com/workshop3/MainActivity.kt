package ta.com.workshop3

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCardViewWithNormalWay()
        initCardViewWithKotlinExtensionWay()
        initApplyButton()
    }

    private fun initCardViewWithNormalWay() {
        val cardView = findViewById(R.id.card_view) as CardView

        cardView.setOnClickListener({ view ->
            Handler().postDelayed({
                Toast.makeText(this, "Clicked " + view.id, Toast.LENGTH_SHORT).show()
            }, 370)
        })

        cardView.setOnTouchListener { v, event ->
            Log.d("ANIMATE", event.toString())
            when (event.action) {
                MotionEvent.ACTION_DOWN ->  {
                    v.animate().cancel()
                    v.animate().scaleY(0.96f).scaleX(0.96f).setDuration(200).start()
                    val img = v.findViewById(R.id.imageBackground)
                    img.animate().scaleY(1.1f).scaleX(1.1f).alpha(0.7f).setDuration(200).start()

                    false
                }
                MotionEvent.ACTION_UP ->  {

                    val xBigScale = ObjectAnimator.ofFloat(v, "scaleX", 1.03f)
                    xBigScale.setDuration(160).repeatCount = 0

                    val yBigScale = ObjectAnimator.ofFloat(v, "scaleY", 1.03f)
                    yBigScale.setDuration(160).repeatCount = 0

                    val xSmallScale = ObjectAnimator.ofFloat(v, "scaleX", 0.985f)
                    xSmallScale.setDuration(140).repeatCount = 0

                    val ySmallScale = ObjectAnimator.ofFloat(v, "scaleY", 0.985f)
                    ySmallScale.setDuration(140).repeatCount = 0

                    val xNormalScale = ObjectAnimator.ofFloat(v, "scaleX", 1f)
                    xNormalScale.setDuration(70).repeatCount = 0

                    val yNormalScale = ObjectAnimator.ofFloat(v, "scaleY", 1f)
                    yNormalScale.setDuration(70).repeatCount = 0

                    val animateSet = AnimatorSet()
                    animateSet.play(xBigScale).with(yBigScale)
                    animateSet.play(xSmallScale).after(xBigScale)
                    animateSet.play(ySmallScale).after(yBigScale)
                    animateSet.play(xNormalScale).after(xSmallScale)
                    animateSet.play(yNormalScale).after(ySmallScale)
                    animateSet.start()

                    val img = v.findViewById(R.id.imageBackground)

                    img.animate().scaleY(1f).scaleX(1f).alpha(1f).setDuration(370).start()

                    false
                }

                MotionEvent.ACTION_CANCEL -> {
                    val img = v.findViewById(R.id.imageBackground)
                    v.animate().scaleY(1f).scaleX(1f).setDuration(200).start()
                    img.animate().scaleY(1f).scaleX(1f).alpha(1f).setDuration(370).start()

                    true
                }

                else -> true
            }

        }
    }

    private fun initCardViewWithKotlinExtensionWay() {
        val cardView2 = findViewById(R.id.card_view2) as CardView

        cardView2.setOnAnimateClickListener(R.id.imageBackground2, { view ->
            Toast.makeText(this, "Clicked " + view.id , Toast.LENGTH_SHORT).show()
        })
    }

    private fun initApplyButton() {
        val applyButton = findViewById(R.id.applyButton)
        applyButton.setOnAnimateClickListener({view ->
            Toast.makeText(this, "Clicked Apply " + view.id , Toast.LENGTH_SHORT).show()
        })
    }
}

