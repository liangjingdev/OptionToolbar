package com.liangjing.toolbarlib1;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * function: (对ToolBar的封装--OptionToolBar)--继承该ToolBarActivity的activity的布局文件中并不需要编写ToolBar控件的代码即可实现
 *            activity中ToolBar的展现，什么时候利用该类最方便？--如果有多个Activity都使用着相同的ToolBar时，那么继承该ToolBarActivity
 *            来实现ToolBar的展示是最便捷的
 *
 *因为这里的MainActivity继承自ToolBarActivity，所以当执行应用程序的时候，ToolBarActivity（即父类）会首先被创建（运行），然后再到其子类被创建。
 *
 * purpose：实践该项目的主要目的是对于一些常用的控件的封装提供一种思路。(思想)
 *
 */
public class MainActivity extends ToolBarActivity {

    private TextView toolBarTitle;//设置toolBar上的title的文字

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//这句话的意思就是：调用父类的方法。
        setContentView(R.layout.activity_main);//因为父类在子类（调用自己的构造函数）被创建的时候同时也会被创建，所以这个R.layout.activity_main（int值）会在此时传递到父类的setContentView()方法中。
    }


    /**
     * function:此处可以利用ToolBar的对象进行相关操作(设置),并且可以添加title布局到ToolBar中
     *
     * @param toolbar
     */
    @Override
    public void onCreateCustomToolBar(Toolbar toolbar) {
        super.onCreateCustomToolBar(toolbar);//这句话的目的：让父类调用自身的该方法(因为父类中的该方法中可能会含有一些相关操作)

        //初始化toolBar的title布局，并将其依附到toolBar上。
        View view = getLayoutInflater().inflate(R.layout.toolbar_option, toolbar);

        //获取到设置titleText的TextView控件，然后设置title文字
        toolBarTitle = (TextView) view.findViewById(R.id.toolBarTitle);
        toolBarTitle.setText("微信");
    }


    /**
     * function:初始化ToolBar上的Menu布局
     *          (如果需要实现含有Menu效果这样的布局，那么就需要重写该方法并实现下列操作--相关操作还可以继续扩展)
     *          (如果不需要的话，那么就不要重写该方法)
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//解析menu布局文件到menu
        MenuItem itemCompat = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(itemCompat);
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

