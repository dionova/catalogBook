INSERT INTO book (title)
VALUES
('1984'),
('Преступление и наказание'),
('Гордость и предубеждение'),
('Война и мир'),
('Старик и море'),
('Скотный двор'),
('Идиот'),
('Анна Каренина'),
('По ком звонит колокол');

INSERT INTO author ("name")
VALUES
('Джордж Оруэлл'),
('Фёдор Достоевский'),
('Джейн Остин'),
('Лев Толстой'),
('Эрнест Хемингуэй');

INSERT INTO books_author (book_id, author_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 4),
(9, 5);