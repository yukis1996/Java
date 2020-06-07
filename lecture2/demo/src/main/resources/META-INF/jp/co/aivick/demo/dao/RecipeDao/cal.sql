select
    /*%expand*/*
from recipes
where cal
between /* beforeCal */0 and  /*afterCal*/0
