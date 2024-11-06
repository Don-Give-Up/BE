use dongiveupdb;

CREATE TABLE article
(
    article_id       BIGINT       NULL,
    member_id        BIGINT       NULL COMMENT 'Auto Increment, 선생님 아이디',
    article_title    VARCHAR(255) NULL,
    article_contents TEXT         NULL,
    PRIMARY KEY (article_id) -- 기본 키 제약 조건을 추가
);

select * from article;