create function update_emp(_id integer, _first_name character varying, _last_name character varying, _email character varying) returns void
    language plpgsql
as
$$
BEGIN
    update employees set
                         first_name = _first_name,
                         last_name = _last_name,
                         email = _email
    where id = _id;
END
$$;

comment on function update_emp(integer, varchar, varchar, varchar) is 'Обновление работника';

alter function update_emp(integer, varchar, varchar, varchar) owner to root;

