select
    /*%expand*/*
from menus
where
/*%if name != null && category != null*/
name
Like /* "%" + name  + "%"  */'a'
AND
/*category*/'a'
/*%elseif name == null*/
    AND
    /*category*/'b'
/*%elseif category == null*/
    AND name
    Like /* "%" + name + "%" */'a'
/*%end*/
