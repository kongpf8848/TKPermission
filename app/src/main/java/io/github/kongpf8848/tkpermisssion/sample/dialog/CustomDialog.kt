package io.github.kongpf8848.tkpermisssion.sample.dialog

import android.content.Context
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import io.github.kongpf8848.tkpermisssion.sample.R


class CustomDialog(context: Context): BaseDialog(
    context=context,
    width = WindowManager.LayoutParams.MATCH_PARENT
)
{

    private var titleTv: TextView? = null
    private var messageTv: TextView? = null
    private var leftButton: TextView? = null
    private var rightButton: TextView? = null

    private var leftClicks: (() -> Unit)? = null
    private var rightClicks: (() -> Unit)? = null


    var title: String? = null
    var message: String? = null
    var leftKey: String? = null
    var leftButtonDismissAfterClick = true
    var rightKey: String? = null
    var rightButtonDismissAfterClick = true

    companion object {
        fun newInstance(context:Context): CustomDialog {
            return CustomDialog(context)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_custom
    }

    override fun initView() {
        titleTv = findViewById(R.id.tv_title)
        messageTv = findViewById(R.id.tv_message)
        leftButton = findViewById(R.id.left_button)
        rightButton = findViewById(R.id.right_button)

        setCancelable(cancelOutside)

        title?.let { text ->
            titleTv?.visibility = View.VISIBLE
            titleTv?.text = text
        }

        message?.let { text ->
            messageTv?.visibility = View.VISIBLE
            messageTv?.text = text
        }

        leftClicks?.let { onClick ->
            leftButton?.text = leftKey
            leftButton?.visibility = View.VISIBLE
            leftButton?.setOnClickListener {
                onClick()
                if (leftButtonDismissAfterClick) {
                    dismiss()
                }
            }
        }

        rightClicks?.let { onClick ->
            rightButton?.text = rightKey
            rightButton?.setOnClickListener {
                onClick()
                if (rightButtonDismissAfterClick) {
                    dismiss()
                }
            }
        }
    }

    fun leftClicks(key: String = "取消", dismissAfterClick: Boolean = true, callback: () -> Unit) {
        leftKey = key
        leftButtonDismissAfterClick = dismissAfterClick
        leftClicks = callback
    }

    fun rightClicks(key: String = "确定", dismissAfterClick: Boolean = true, callback: () -> Unit) {
        rightKey = key
        rightButtonDismissAfterClick = dismissAfterClick
        rightClicks = callback
    }
}
