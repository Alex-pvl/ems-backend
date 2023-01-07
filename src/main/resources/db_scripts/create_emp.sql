create function create_emp(_first_name character varying, _last_name character varying,
                           _email character varying) returns integer
    language plpgsql
as
$$
DECLARE
    _id integer;
BEGIN
    insert into employees(first_name, last_name, email)
    values (_first_name, _last_name, _email);

    select id into _id from employees where first_name like _first_name;

    return _id;
END
$$;

comment on function create_emp(varchar, varchar, varchar) is 'Создание нового работника';

alter function create_emp(varchar, varchar, varchar) owner to root;


