# HeadFirst 设计模式

## 目标
1. 追逐本质
2. 理解至上 / 易懂
3. 继往圣绝学

## 设计模式的学习大约 5 个境界
- 从未学习认知 设计模式 并认为毫无意义（ignorant）
- 学习使用 设计模式 在生产代码中 并认为设计绝妙（worship blindly）
- 过度使用 设计模式 复盘后认为 存在大量冗余无用设计（anew cognize）
- 精简改造 设计模式 在生产环境中 获取良好收效（self-dependent innovation）
- 随心所欲 提笔即是经典（godlike）

## 食用方式
推荐 视频讲解(前三章讲的比较水，有时间安排重构)
- 设计模式入门+策略模式 https://www.bilibili.com/video/BV1uN41197aq
- 观察者模式 BV1aZ4y1A7sD
- 装饰者模式 BV1TK4y1D7t8

代码自身确实含有行文思路的提示，可通过 git 时间来判断
但是吧，这实在是太麻烦了

## Package 设计
1. 以 平常/差代码(bad eg) 令读者 身临其境
2. 通过 简单改良(improve eg) 令读者 渐入佳境
3. 给出 优良代码(great eg) 令读者 惊叹叫绝

后面的 4、5、6... 基本就都是些 补充性的
例如: homewrok 家庭作业，custom 自己魔改，expend 拓展

## 整体设计
考虑中: 代码中的注释很多，虽然更加贴近代码利于理解，但仍会显得混乱
理应再抽出一个模块 来 对认知到的信息 进行总结

```text
src 代码块
    各模式
        badeg
        improvedeg
        greateg
resource 资源
    各模式
        总结
        代码所需资源
```
