select
    /*%expand*/*
from recipes
where name
Like /*%name%*/