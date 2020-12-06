package com.github.kongpf8848.tkpermisssion.sample.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import com.github.kongpf8848.tkpermisssion.sample.R

/**
 * Dialog基类
 */
abstract class BaseDialog @JvmOverloads constructor(
    context: Context, style:Int= R.style.DialogStyle,
    val width:Int=WindowManager.LayoutParams.WRAP_CONTENT,
    val height:Int=WindowManager.LayoutParams.WRAP_CONTENT,
    val gravity:Int=Gravity.CENTER,
    val animationId:Int=0,
    val cancelOutside:Boolean= true,
    val cancelable: Boolean = true,
    val backgroundDimEnabled:Boolean=true,
    val dimAmount:Float=0.6f
) : Dialog(context,style), View.OnClickListener {


    abstract fun getLayoutId():Int

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LayoutInflater.from(context).inflate(getLayoutId(),null,false))
        window?.apply {
            attributes.width=width
            attributes.height=height
            attributes.gravity=gravity
            if (animationId != 0) {
                setWindowAnimations(animationId)
            }
            if(backgroundDimEnabled){
                addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                attributes.dimAmount=dimAmount
            }
        }

        setCanceledOnTouchOutside(cancelOutside)
        setCancelable(cancelable)
        initView()
    }

    open fun initView() {}

    override fun onClick(v: View?) {}
}