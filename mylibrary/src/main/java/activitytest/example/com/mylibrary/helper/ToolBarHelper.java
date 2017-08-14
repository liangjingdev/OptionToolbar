package activitytest.example.com.mylibrary.helper;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import activitytest.example.com.mylibrary.R;

/**
 * ToolBarHelper.java 是 Activity 和 toolbar 的关联类
 * 这个类的功能是：先创建一个 ViewGroup 来作为视图的父 View，
 * 然后把用户定义的 View，和 toolBar 依次 Add 到 ViewGroup 中。
 * 然后提供方法供外部取得其父视图容器以及ToolBar.
 */

public class ToolBarHelper {

    /*上下文，创建view的时候需要用到。因为这个类只是个工具类，只是起到辅助的作用，所以需要利用到context，以明确我们在为哪个context（在此处可指Activity）工作。*/
    private Context mContext;

    /*base view*/
    private FrameLayout mContentView;

    /*用户定义的view*/
    private View mUserView;

    /*toolbar*/
    private Toolbar mToolBar;

    /*视图构造器*/
    private LayoutInflater mInflater;

    /*
    * 两个属性
    * 1、toolbar是否悬浮在窗口之上
    * 2、toolbar的高度获取
    * */
    private static int[] ATTRS = {
            R.attr.windowActionBarOverlay,
            R.attr.actionBarSize
    };

    public ToolBarHelper(Context context, int layoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);//获取与传进来的context相对应的视图构造器。
        /*初始化整个界面*/
        initContentView();
        /*初始化用户定义的布局*/
        initUserView(layoutId);
        /*初始化toolbar*/
        initToolBar();
    }

    private void initContentView() {
        /*直接创建一个帧布局，作为视图容器的父容器。想要为传进来的那个Context创建一个视图以展示出来*/
        mContentView = new FrameLayout(mContext);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView.setLayoutParams(params);

    }

    private void initToolBar() {
        /*通过inflater获取toolbar的布局文件*/
        View toolbar = mInflater.inflate(R.layout.toolbar, mContentView);
        mToolBar = (Toolbar) toolbar.findViewById(R.id.id_tool_bar);
    }

    private void initUserView(int id) {
        mUserView = mInflater.inflate(id, null);//这里的id其实也就是当前activity(R.layout.activity_main)布局id
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(ATTRS);
        /*获取主题中定义的悬浮标志*/
        boolean overly = typedArray.getBoolean(0, false);
        /*获取主题中定义的toolbar的高度*/
        int toolBarSize = getActionBarHeight(mContext);
        typedArray.recycle();
        /*如果是悬浮状态，则不需要设置间距。意思就是该ToolBar控件是否悬浮在视图上方*/
        params.topMargin = overly ? 0 : toolBarSize;
        //为父容器中添加view视图
        mContentView.addView(mUserView, params);

    }

    public FrameLayout getContentView() {
        return mContentView;
    }

    public Toolbar getToolBar() {
        return mToolBar;
    }


    /**
     * 动作栏高度根据应用主题而有所不同。如果您使用AppCompatActivity，大多数情况下，高度将与正常活动不同。
     *
     * 如果你使用AppCompatActivity，你应该使用R.attr.actionBarSize而不是android.R.attr.actionBarSize
     * @param mcontext
     * @return
     */
    public static int getActionBarHeight(Context mcontext) {
        TypedValue typedValue = new TypedValue();

        int attributeResourceId = android.R.attr.actionBarSize;
        if (mcontext instanceof AppCompatActivity) {
            attributeResourceId = R.attr.actionBarSize;
        }

        if (mcontext.getTheme().resolveAttribute(attributeResourceId, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, mcontext.getResources().getDisplayMetrics());
        }

        return (int) Math.floor(mcontext.getResources()
                .getDimension(R.dimen.abc_action_bar_default_height_material));
    }
}


/**
 * inflate

 View inflate (int resource,
 ViewGroup root)

 从指定的xml资源扩充一个新的视图层次结构。抛出 InflateException错误。

 参数
 resource	int：要加载的XML布局资源的ID（例如， R.layout.main_page）
 root	ViewGroup：可选视图为生成层次结构的父级。
 退货
 View	膨胀的层次结构的根视图。如果提供了root，这是根视图; 否则它是膨胀的XML文件的根。
 */

/**
 * ViewGroup.LayoutParams
 *
 * LayoutParams被视图用于告诉他们的父母他们想要如何布置。查看 ViewGroup Layout Attributes 此类支持的所有子视图属性的列表。

 基本的LayoutParams类仅描述了视图对宽度和高度的要求。对于每个维度，它可以指定以下之一：

 FILL_PARENT（在API 8级及更高版本中重命名为MATCH_PARENT），这意味着该视图要与其父级（减去填充）一样大
 WRAP_CONTENT，这意味着该视图想要足够大以附加其内容（加上填充）
 */