from typing import TypedDict
from inteface import Databaseinteface

class MysqlRepository(Databaseinteface):

    def select_one(self) -> Dict:
        return {
            'sucess': True
            'data': 'Ola mundo'
        }