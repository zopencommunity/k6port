# k6port

[Grafana k6](https://k6.io/) is a modern load testing tool built for testing APIs, microservices, and websites.

## Installation

```bash
zopen install k6
```

## Usage

Create `test.js`:

```javascript
import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 10,
  duration: '30s',
};

export default function () {
  const res = http.get('https://test-api.k6.io/public/crocodiles/');
  check(res, { 'status is 200': (r) => r.status === 200 });
  sleep(1);
}
```

Run:

```bash
k6 run test.js
```

## z/OS Notes

Tag scripts with UTF-8 encoding:

```bash
chtag -tc 1208 test.js
```

## Build from Source

```bash
git clone https://github.com/msradam/k6port.git
cd k6port
zopen build
```

## References

- Upstream: https://github.com/grafana/k6
- z/OS port article: https://medium.com/theropod/go-ing-native-porting-grafana-k6-to-z-os-with-go-f7f73267c1c
- Upstream PR: https://github.com/grafana/k6/pull/5548
