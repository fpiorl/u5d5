#!/bin/bash
# launcher per pgadmin4 che a quanto pare manca nell'installazione
# su arch linux
exec /usr/bin/electron39 /usr/pgadmin4/bin/resources/app "$@"
