USE adlister_db;

TRUNCATE ads;
SET foreign_key_checks = 0;
TRUNCATE users;

INSERT INTO ads (user_id, title, description) VALUES (1,'Free Frisbee', 'Free, lightly chewed, frisbee. Have, no take!'), (1,'Dog walker needed', 'Good good boy looking for good good steps. HMU.'), (2,'Dog and Computer missing...', 'Anyone seen a german shepard around Plymouth? I can\'t find my dog... Answers to Franky, and has a blue collar with an American Flag bandana. Also, I can\' find my laptop... It is a 2017 Dell XPS 13, navy blue, and an i7 processor. Someone please help. I\'ve lost my best friend, and my dog.'), (3, 'Cool Dog Found', 'My dudes, I have found a ride or die dog that is absolutely radical! My dudes, he\'s got a rad bandana around his neck, and SWEET aviator shades! Bro, this dude is the boss! Not reporting lost cause I love this dude!'), (1, 'XPS Laptop for Sale', 'New roommate and need to lose some clutter. Navy blue laptop for sale, like new condition with small scratches on track pad.');

SELECT * FROM ads;

INSERT INTO categories (title) VALUES ();