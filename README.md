# DevOps demo — lessons 4.13 and 4.14

Standalone learning application for the AIE DevSecOps practicals. The Java app was copied from the existing course demo; this repository contains only the demo application and its pipeline configuration.

## Run and test

Requires Java 21. Run `./mvnw test` to verify `/hello` and `/health`, or `./mvnw spring-boot:run` to serve the app on port 8080. Railway can supply its port through `PORT`.

## Security gates

CircleCI runs `build`, Snyk dependency analysis (`snyk_scan`), and source analysis (`snyk_code`) in parallel. Tests follow the build. Publishing requires successful tests and both scans; Railway redeployment follows publishing. HIGH or CRITICAL dependency findings block release. A red security scan is an expected learning outcome when genuine findings exist; setup and authentication errors are not vulnerability findings.

Snyk orb 2.3.0 and CLI 1.1308.1 follow the lesson's pinned versions. Credentials belong in CircleCI environment variables, never this repository: `SNYK_TOKEN`, `DOCKER_USERNAME`, `DOCKER_PASSWORD`, `RAILWAY_TOKEN`, and `RAILWAY_SERVICE_ID`.

Lesson 4.14 adds OSV-Scanner and ZAP workflows separately. GitHub Actions uses the non-secret repository variable `APP_URL` for the live application.

## Initial findings

The Snyk website scan on 24 October 2026 found 21 dependency issues (3 Critical, 9 High, 9 Medium). Its source-code analysis reported no findings. The dependency findings and fix advice are recorded in [security ticket #1](https://github.com/simon97153-prog/devops-demo/issues/1). These counts describe the initial snapshot and may change as new advisories are published.

The existing Railway demo pulls `simon97153/devops-demo:latest` from Docker Hub and exposes `/hello` and `/health`. Its app URL is stored in the GitHub Actions repository variable `APP_URL`. Deployment credentials must be configured separately in CircleCI; a reachable app alone does not establish that the new pipeline can redeploy it.

## Lesson references

- [Lesson 4.13](https://github.com/su-ntu-sctp/ai-4.13-devsecops-foundation/blob/main/lesson.md)
- [Lesson 4.14](https://github.com/su-ntu-sctp/ai-4.14-devsecops-practicals/blob/main/lesson.md)
