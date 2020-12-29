-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2020-12-29 13:27:02
-- 服务器版本： 8.0.22
-- PHP 版本： 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `forumsys`
--

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE `comment` (
  `id` int NOT NULL,
  `post_id` int DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `content` text,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `comment`
--

INSERT INTO `comment` (`id`, `post_id`, `author`, `content`, `date`) VALUES
(3, 14, 'user1', '怎么有人没水了呀', '2020-12-14'),
(4, 11, 'user1', '感谢分享！', '2020-12-14'),
(5, 12, 'user1', '+1！！！', '2020-12-14'),
(6, 12, 'user1', '11111111111', '2020-12-14'),
(12, 11, 'user1', '1111', '2020-12-16'),
(13, 18, 'zzr', '1111', '2020-12-16'),
(14, 11, 'user1', '111', '2020-12-16');

-- --------------------------------------------------------

--
-- 表的结构 `post`
--

CREATE TABLE `post` (
  `id` int NOT NULL COMMENT '//序号',
  `title` varchar(255) NOT NULL COMMENT '//标题',
  `author` varchar(128) NOT NULL COMMENT '//作者',
  `type` varchar(40) NOT NULL COMMENT '//类型',
  `content` text NOT NULL COMMENT '//文章内容',
  `date` date NOT NULL COMMENT '//发布日期'
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

--
-- 转存表中的数据 `post`
--

INSERT INTO `post` (`id`, `title`, `author`, `type`, `content`, `date`) VALUES
(11, 'C++入门分享', 'user1', '学习讨论', '学习 C++，可以分为两大部分：C++语言和 C++标准库先说 C++语言部分：1.语言基础，推荐图书 C++ Primer（中文版 第5版）2.进一步提升，可以读 Effective C++（第3版 中文版）和 More Effective C++（中文版）这两本书，帮助你写更规范专业的 C++代码3.有C基础的，也可以直接看 C++面向对象开发 | 博览网 Boolan对1&2中的重点难点做了深入剖析，BTW 课程主讲就是上面两书的翻译侯捷老师然后 C++标准库的部分：1.经典之作：侯捷的 《STL源码剖析》2.觉得书难啃的，可以看对应的在线课 STL标准库与泛型编程 | 博览网 Boolan课程还有个综合版 《C++开发工程师》微专业 | 博览网 Boolan 适合想系统学习 C++的掌握这两部分，才是真正的 C++入门了，即可以从事 C++开发的相关岗位工作。', '2020-12-14'),
(12, '表白钟俊龙', 'user1', '表白墙', '表白19计本3班钟俊龙！！！', '2020-12-14'),
(14, '怎么宿舍又没水了', 'user2', '校园生活', '包租婆没水了！！！', '2020-12-14'),
(16, '有人有二手小电驴出售吗', 'user1', '校园生活', '如题！', '2020-12-14'),
(18, '求大一下学期计本书单！', 'zzr', '校园生活', '求大一下学期计本书单！', '2020-12-16');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `uid` int NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `rtime` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`uid`, `name`, `passwd`, `sex`, `rtime`) VALUES
(1, 'user1', '111111', 'man', '2020-12-08'),
(3, 'user2', '222222', 'man', '2020-12-09'),
(6, 'zzr', '111111', 'man', '2020-12-16');

--
-- 转储表的索引
--

--
-- 表的索引 `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- 使用表AUTO_INCREMENT `post`
--
ALTER TABLE `post`
  MODIFY `id` int NOT NULL AUTO_INCREMENT COMMENT '//序号', AUTO_INCREMENT=19;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `uid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
