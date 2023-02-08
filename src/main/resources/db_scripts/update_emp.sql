create function update_emp(_id integer, _first_name character varying, _last_name character varying, _email character varying, _department integer, _role_id integer) returns void
    language plpgsql
as
$$
BEGIN
    update employees set
                         first_name = _first_name,
                         last_name = _last_name,
                         email = _email,
                         department_id = _department,
                         role_id = _role_id
    where id = _id;
END
$$;

comment on function update_emp(integer, varchar, varchar, varchar, integer, integer) is 'Обновление работника';

alter function update_emp(integer, varchar, varchar, varchar, integer, integer) owner to root;

