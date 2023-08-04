create table article (
                         id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         regDate DATETIME NOT NULL,
                         updateDate DATETIME NOT NULL,
                         title CHAR(200) NOT NULL,
                         content LONGTEXT NOT NULL
);

create table `member` (
                          id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          regDate DATETIME NOT NULL,
                          updateDate DATETIME NOT NULL,
                          loginId CHAR(100) NOT NULL,
                          loginPw CHAR(100) NOT NULL,
                          `name` CHAR(100) NOT NULL
)