# XRecyclerView_Zf介绍
在XRecyclerView源码基础上修改,再次感谢原作者的思路和源码。

### XRecyclerVie原地址
感谢原作者的源码提供，https://github.com/jianghejie/XRecyclerView

### 优点
在XRecyclerView源码基础上修改，以支持自定义header和footer
### 缺点
1. 去除了addHeader的方法支持；
2. 去除了无数据时，empty的支持
3. 去除了和Material Design联动滑动的支持。

### XRecyclerVie_zf自定义footer和header
1. 其他方法和原地址（https://github.com/jianghejie/XRecyclerView/blob/master/README.md）的文档相同
2. header必须继承自com.xrecycler.wzf.xrecyclerview_zf.ptr.HeaderView的抽象类；
3. footer必须继承自com.xrecycler.wzf.xrecyclerview_zf.ptr.FooterView的抽象类;
4. 调用方法setRefreshHeader（HeaderView）传递自定义的header
5. 调用方法setFootView（FooterView）传递自定义的footer

### 具体可下载demo查看
