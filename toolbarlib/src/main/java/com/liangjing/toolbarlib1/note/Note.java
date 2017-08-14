package com.liangjing.toolbarlib1.note;

/**
 * Created by liangjing on 2017/8/14.
 *
 */

public class Note {

//ToolBarActivity
/**
 * setIconified
 *
 * void setIconified（boolean iconify）
 *
 * 图标化或扩展SearchView。图标化时，任何查询文本都将被清除。这是一个临时状态，不会覆盖设置的默认图标化状态 setIconifiedByDefault(boolean)。如果默认状态是图标化的，那么这里的false只有在用户关闭该字段之前才有效。并且如果默认状态被展开，那么这里的true只会清除文本字段而不是关闭它。
 *
 * 参数
 * iconify	boolean：一个真正的值会将SearchView折叠到一个图标，而一个false会展开它。
 */

    /** setIconifiedByDefault
     *
     * void setIconifiedByDefault（boolean iconified）
     *
     * 设置搜索字段的默认或静止状态。如果为true，则默认显示单个搜索图标，并在按下时展开以显示文本字段和其他按钮。此外，如果默认状态为图标，则当按下关闭按钮时，它将折叠到该状态。对此属性的更改将立即生效。
     *
     * 默认值为true。
     *
     * 相关XML属性：
     *
     * android.support.v7.appcompat：iconifiedByDefault
     * 参数
     * iconified	boolean：搜索字段是否应该默认图标化
     * /


     /** 那个父类的实例是在调用子类的构造函数的时候创建的，
     * 被包含在子类对象的内部，它里面的属性和方法必须通过子类对象才能访问到，
     * 除非你是单独创建了一个父类实例（不是在创建子类实例的时候创建的）。
     * /


     /** <p>
     * showOverflowMenu
     * <p>
     * boolean showOverflowMenu ()
     * 显示相关菜单中的溢出项目。
     * <p>
     * 退货
     * boolean	如果菜单能够显示，则为true，否则为false
     * /


     * showOverflowMenu
     * <p>
     * boolean showOverflowMenu ()
     * 显示相关菜单中的溢出项目。
     * <p>
     * 退货
     * boolean	如果菜单能够显示，则为true，否则为false
     */



    //ToolBarHelper

/**
 * inflate
 * <p>
 * View inflate (int resource,
 * ViewGroup root)
 * <p>
 * 从指定的xml资源扩充一个新的视图层次结构。抛出 InflateException错误。
 * <p>
 * 参数
 * resource	int：要加载的XML布局资源的ID（例如， R.layout.main_page）
 * root	ViewGroup：可选视图为生成层次结构的父级。
 * 退货
 * View	膨胀的层次结构的根视图。如果提供了root，这是根视图; 否则它是膨胀的XML文件的根。
 * <p>
 * ViewGroup.LayoutParams
 * <p>
 * LayoutParams被视图用于告诉他们的父母他们想要如何布置。查看 ViewGroup Layout Attributes 此类支持的所有子视图属性的列表。
 * <p>
 * 基本的LayoutParams类仅描述了视图对宽度和高度的要求。对于每个维度，它可以指定以下之一：
 * <p>
 * FILL_PARENT（在API 8级及更高版本中重命名为MATCH_PARENT），这意味着该视图要与其父级（减去填充）一样大
 * WRAP_CONTENT，这意味着该视图想要足够大以附加其内容（加上填充）
 */

/**
 * ViewGroup.LayoutParams
 *
 * LayoutParams被视图用于告诉他们的父母他们想要如何布置。查看 ViewGroup Layout Attributes 此类支持的所有子视图属性的列表。

 基本的LayoutParams类仅描述了视图对宽度和高度的要求。对于每个维度，它可以指定以下之一：

 FILL_PARENT（在API 8级及更高版本中重命名为MATCH_PARENT），这意味着该视图要与其父级（减去填充）一样大
 WRAP_CONTENT，这意味着该视图想要足够大以附加其内容（加上填充）
 */


}
