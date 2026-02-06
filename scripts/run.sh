#!/bin/sh
# mi scusi ma non mi trovo a usare intellij
# ho nvim con easymotion, coc, lsp e mille altre robe 
# git rev-parse -> da la root della repo git, e' un bel trick
pushd $( git rev-parse --show-toplevel )
	bash ./mvnw spring-boot:run
popd
