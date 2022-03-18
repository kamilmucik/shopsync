#!/usr/bin/env bash
export OS_URI=http://127.0.0.1:8088
export KEY_STORE_PATH=
export KEY_STORE_PASS=
export TRUST_STORE_PATH=
export TRUST_STORE_PASS=

mvn -P integration-tests verify