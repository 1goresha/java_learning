create table interviews
(
    id bigserial,
    date_begin date,
    date_end date,
    name varchar(200),
    is_active boolean,
    primary key (id)
);

create table questions
(
    id bigserial,
    display_order bigint,
    text varchar(200),
    interview_id bigserial references interviews(id),
    primary key (id)
);
-------------------------------------------------------------------------------------
insert into interviews
(
    date_begin, date_end, name, is_active
)
values
(
    '01-08-2020',
    '02-08-2020',
    'система образования',
     true
);

insert into interviews
(
    date_begin, date_end, name, is_active
)
values
(
    '05-08-2020',
    '07-08-2020',
    'отечественный автром',
     true
);

insert into interviews
(
    date_begin, date_end, name, is_active
)
values
(
    '08-08-2020',
    '12-08-2020',
    'система здравохранения',
     false
);

insert into interviews
(
    date_begin, date_end, name, is_active
)
values
(
    '10-08-2020','16-08-2020','covid - 19',true
);
----------------------------------------------------------------------------------------------
insert into questions
(
    display_order,text,interview_id
)
values
(
     1,'как вы относитесь к системе образования в нашей стране?',1
);

insert into questions
(
    display_order,text,interview_id
)
values
(
     2,'плюсы и минусы нашего образования?',1
);

insert into questions
(
    display_order,text,interview_id
)
values
(
     3,'на ваш взгляд имеет ли диплом какое либо значение?',1
);

insert into questions
(
    display_order,text,interview_id
)
values
(
     4,'что бы вы поменяли в первую очередь, если бы у вас была такая возможность?',1
);
--------------------------------------------------------------------------------------------
insert into questions
(
    display_order,text,interview_id
)
values
(
    1,'научатся ли у нас когда нибудь делать хорошие автомобили?',2
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    2,'готовы ли вы переплачивать за качество?',2
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    3,'что для вас значи идельный автомобиль?',2
);
------------------------------------------------------------------------------------------------
insert into questions
(
    display_order,text,interview_id
)
values
(
    1,'наши система здравохранения лечит или все таки колечит?',3
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    2,'доверяете ли вы такой бесплатной медицине?',3
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    3,'что бы вы поменяли, если бы у вас была такая возможность?',3
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    4,'часто ли вы прибегаете к помощи врачей или же все таки вы больше доверяете народным средствам?',3
);
---------------------------------------------------------------------------------------------------------
insert into questions
(
    display_order,text,interview_id
)
values
(
    1,'как вы относитесь ко всей шумихе вокруг covid - 19?',4
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    2,'ваши действия, если вы обнаружите у себя все симптомы первей, чем их обнаружит врач, самоизолируетесь ли вы или никому ничего не скажите и будете как ни в чем не бывало жить в своем ритме?',4
);

insert into questions
(
    display_order,text,interview_id
)
values
(
    3,'верите ли во все это?',4
);
