package com.liangjing.toolbarlib1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.liangjing.toolbarlib1.helper.ToolBarHelper;


/**
 * 1、 toolbar.xml中配置 toolbar 的基本属性：
 * toolbar 的宽高，toolbar 的背景颜色等其他样式
 * 2、ToolBarActivity.java是所以需要使用 toolbar Activity 的父类，
 * 这里我把他定义为抽象类，因为单独的这个类不能完成任何功能
 * 3、ToolBarActivity.java的内容：主要代码是在setContentView（int id） 实现
 * 4、该Activity首先从工具类ToolBarHelper中取得父视图以及ToolBar,然后设置好父视图，接着
 * 可以利用ToolBar做一些相应的处理操作
 */

public abstract class ToolBarActivity extends AppCompatActivity {

    private ToolBarHelper mToolBarHelper;

    public Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * function:重写setContentView方法--目的：让ToolBarHelper工具类来生成布局(带有ToolBar)。
     *          因为按道理来说，如果不重写setContentView()方法的话，那么生成的布局就是该activity的布局文件，
     *          所以我们如果想要从内部去为该activity的布局文件添加上ToolBar控件的话，那么我们就需要去拦截
     *          setContentView()方法，然后对该方法进行重写(利用某些工具类来生成新的一个布局),
     *          之后又再通过setContentView(新的布局内容view)继续上传至顶级父类(AppCompatActivity)，
     *          最后顶级父类将会把最新的内容view给绘制出来。
     *
     *         这里的layoutResID即子类传递过来的R.layout.activity_main.
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {

        mToolBarHelper = new ToolBarHelper(this, layoutResID);//这个this指的是当前的context。
        toolbar = mToolBarHelper.getToolBar();
        setContentView(mToolBarHelper.getContentView());//为活动设置视图
        /*把 toolbar 设置到Activity 中*/
        setSupportActionBar(toolbar);
        /*自定义的一些操作*/
        onCreateCustomToolBar(toolbar);
    }


    /**
     * function:此处可以利用ToolBar的对象进行相关操作(设置),并且可以添加title布局到ToolBar中
     *
     * @param toolbar
     */
    public void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(0, 0);
        toolbar.showOverflowMenu();
    }


}

