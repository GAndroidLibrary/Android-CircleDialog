package com.mylhyl.circledialog.params;

import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.view.Gravity;

import com.mylhyl.circledialog.res.values.CircleColor;
import com.mylhyl.circledialog.res.values.CircleDimen;

/**
 * 输入框参数
 * Created by hupei on 2017/3/31.
 */
public class InputParams implements Parcelable {
    public static final Creator<InputParams> CREATOR = new Creator<InputParams>() {
        @Override
        public InputParams createFromParcel(Parcel source) {
            return new InputParams(source);
        }

        @Override
        public InputParams[] newArray(int size) {
            return new InputParams[size];
        }
    };

    /**
     * 输入框与body视图的距离
     */
    public int[] margins = CircleDimen.INPUT_MARGINS;
    /**
     * 输入框的高度
     */
    public int inputHeight = CircleDimen.INPUT_HEIGHT;
    /**
     * 输入框提示语
     */
    public String hintText;
    /**
     * 输入框提示语颜色
     */
    public int hintTextColor = CircleColor.content;
    /**
     * 输入框背景资源文件
     */
    public int inputBackgroundResourceId;
    /**
     * 输入框边框线条粗细
     */
    public int strokeWidth = 1;
    /**
     * 输入框边框线条颜色
     */
    public int strokeColor = CircleColor.inputStroke;
    /**
     * 输入框的背景
     */
    public int inputBackgroundColor;
    /**
     * body视图的背景色
     */
    public int backgroundColor;
    /**
     * 输入框字体大小
     */
    public int textSize = CircleDimen.CONTENT_TEXT_SIZE;
    /**
     * 输入框字体颜色
     */
    public int textColor = CircleColor.title;
    /**
     * 输入类型
     */
    public int inputType = InputType.TYPE_NULL;
    /**
     * 文字对齐方式，默认左上角
     */
    public int gravity = Gravity.LEFT | Gravity.TOP;
    /**
     * 是否触发自动关闭对话框
     */
    public boolean isManualClose;
    /**
     * 文本
     */
    public String text;
    /**
     * 内间距 [left, top, right, bottom]
     */
    public int[] padding = CircleDimen.INPUT_PADDING;
    /**
     * 字样式
     * {@linkplain Typeface#NORMAL NORMAL}
     * {@linkplain Typeface#BOLD BOLD}
     * {@linkplain Typeface#ITALIC ITALIC}
     * {@linkplain Typeface#BOLD_ITALIC BOLD_ITALIC}
     */
    public int styleText = Typeface.NORMAL;
    /**
     * 输入框限制字符数量，如counter=50：中(占2个)英(1个)文总字符数
     */
    public int maxLen;
    /**
     * 外边距 [右，下]
     */
    public int[] counterMargins = CircleDimen.INPUT_COUNTER_MARGINS;
    public int counterColor = CircleColor.inputCounter;

    public InputParams() {
    }

    protected InputParams(Parcel in) {
        this.margins = in.createIntArray();
        this.inputHeight = in.readInt();
        this.hintText = in.readString();
        this.hintTextColor = in.readInt();
        this.inputBackgroundResourceId = in.readInt();
        this.strokeWidth = in.readInt();
        this.strokeColor = in.readInt();
        this.inputBackgroundColor = in.readInt();
        this.backgroundColor = in.readInt();
        this.textSize = in.readInt();
        this.textColor = in.readInt();
        this.inputType = in.readInt();
        this.gravity = in.readInt();
        this.isManualClose = in.readByte() != 0;
        this.text = in.readString();
        this.padding = in.createIntArray();
        this.styleText = in.readInt();
        this.maxLen = in.readInt();
        this.counterColor = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.margins);
        dest.writeInt(this.inputHeight);
        dest.writeString(this.hintText);
        dest.writeInt(this.hintTextColor);
        dest.writeInt(this.inputBackgroundResourceId);
        dest.writeInt(this.strokeWidth);
        dest.writeInt(this.strokeColor);
        dest.writeInt(this.inputBackgroundColor);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.textSize);
        dest.writeInt(this.textColor);
        dest.writeInt(this.inputType);
        dest.writeInt(this.gravity);
        dest.writeByte(this.isManualClose ? (byte) 1 : (byte) 0);
        dest.writeString(this.text);
        dest.writeIntArray(this.padding);
        dest.writeInt(this.styleText);
        dest.writeInt(this.maxLen);
        dest.writeInt(this.counterColor);
    }
}
