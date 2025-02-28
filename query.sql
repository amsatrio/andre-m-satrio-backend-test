select p.id_murid,m.name,(select pp.status from pendidikan pp where pp.id = max(p.id)) as pendidikan_terakhir,m.time_create,max(p.time_create) as time_updated
from pendidikan p
join murid m on m.id = p.id_murid
group by p.id_murid;
