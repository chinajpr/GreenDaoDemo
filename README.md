# GreenDaoDemo
#### 1.api即将过时，导致编译报错

- 问题：WARNING: API 'variant.getJavaCompiler()' is obsolete and has been replaced with 'variant.getJavaCompileProvider()'.

It will be removed at the end of 2019.

- 原因：GreenDao中使用了即将过时的api
- 解决：在Terminal中执行gradlew -Pandroid.debug.obsoleteApi=true命令

#### 2.表结构变化导致崩溃

###### 解决：
- 1）可以卸载重
- 2）在app下的gradle中，表增加或者表结构变化时，schemaVersion + 1

      greendao {
          schemaVersion 2 //数据库版本号，更新时要修改+1
          daoPackage 'com.jpr.greendaodemo.db'
          targetGenDir 'src/main/java'
      }

#### 3.表关联

在一对一表关联和一对多表关联的时候，要使用主键关联，如果使用其他属性关联，就很可能出问题。因为greenDao默认是去关联主键的，我们手动使用了其他属性，很有可能在后面的查询等操作的时候出错。


