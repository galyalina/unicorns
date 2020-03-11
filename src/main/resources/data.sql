insert into unicorn(name) select 'Pinky Pie' where not exists (SELECT 1 FROM unicorn WHERE name = 'Pinky Pie');

insert into unicorn(name) select 'Rainbow Dash' where not exists (SELECT 1 FROM unicorn WHERE name = 'Rainbow Dash');

insert into unicorn(name) select 'Fluttershy' where not exists (SELECT 1 FROM unicorn WHERE name = 'Fluttershy');

insert into unicorn(name, rest_time) select 'Twilight Sparkle', 30 where not exists (SELECT 1 FROM unicorn WHERE name = 'Twilight Sparkle');

insert into unicorn(name, rest_time) select 'Some awesome unicorn', 5 where not exists (SELECT 1 FROM unicorn WHERE name = 'Some awesome unicorn');
