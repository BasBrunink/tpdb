# TPDB Improvement Tasks Checklist

Use this checklist to guide incremental improvements across architecture, code quality, security, testing, DevOps, and documentation. Each item is actionable and can be checked off when completed.

1. [ ] Establish repository-wide contribution standards
   - [ ] Add CONTRIBUTING.md with branching, commit message, and PR guidelines
   - [ ] Add a CODE_OF_CONDUCT.md and SECURITY.md for responsible disclosure
   - [ ] Define a versioning strategy (SemVer) and release notes template

2. [ ] Introduce environment configuration hygiene
   - [ ] Externalize secrets and credentials (DB, Keycloak) via environment variables and profiles; remove hardcoded creds from application.yml
   - [ ] Provide application-local.yml.example and .env.example files
   - [ ] Add .gitignore entries and a pre-commit check to prevent committing secrets

3. [ ] Backend: Baseline architecture hardening
   - [ ] Add a global exception handler (@ControllerAdvice) for consistent error responses (RFC7807/problem+json)
   - [ ] Introduce DTOs and mappers to avoid exposing entities directly (future-proofing)
   - [ ] Add request validation (Jakarta Validation) with meaningful error messages
   - [ ] Define a consistent package structure (api, service, domain, repository, config, security)

4. [ ] Backend: Security improvements
   - [ ] Replace setAllowedHeaders("*") with an explicit allowlist and document rationale
   - [ ] Parameterize CORS origins via properties (per profile) instead of hardcoding localhost:4200
   - [ ] Narrow DEBUG logging for org.springframework.security in prod profiles; use INFO in prod
   - [ ] Add integration tests for authorization rules (public, authenticated, role-based)
   - [ ] Ensure Keycloak role mapping covers both realm and client roles if needed

5. [ ] Backend: Persistence and migrations
   - [ ] Introduce Flyway (or Liquibase) for schema migrations; disable JPA ddl-auto in non-dev profiles
   - [ ] Provide baseline migration scripts and instructions for local/dev/test
   - [ ] Configure test profile to use H2 with compatible Postgres mode and run migrations

6. [ ] Backend: Observability and operations
   - [ ] Add Spring Boot Actuator with health, info, metrics, and prometheus endpoints
   - [ ] Configure OpenAPI/Swagger (springdoc-openapi) with security schemes for JWT
   - [ ] Add structured logging (JSON) option and correlation IDs (e.g., MDC) for distributed tracing readiness

7. [ ] Backend: Testing strategy
   - [ ] Add unit tests for SecurityConfig and KeycloakRealmRoleConverter
   - [ ] Add WebMvc/WebFlux tests for controllers (public/admin endpoints)
   - [ ] Add testcontainers for Postgres integration tests (if using real DB interactions)
   - [ ] Define a minimum coverage threshold in Jacoco and avoid over-broad excludes

8. [ ] Frontend: Configuration and security
   - [ ] Move Keycloak config and API base URLs to environment.ts files per build target (dev, prod)
   - [ ] Avoid direct references to localhost ports; use Angular proxy or env-driven base URLs
   - [ ] Ensure token interceptor refreshes token when near expiry (leverage keycloak-angular auto refresh already configured; verify behavior)
   - [ ] Guard admin routes using canActivate with role checks and handle unauthorized UX

9. [ ] Frontend: UX and error handling
   - [ ] Implement a global HTTP error handler and user-friendly notifications
   - [ ] Add a loading indicator and retry/backoff for transient API errors
   - [ ] Add logout on 401/403 with a returnUrl parameter to rehydrate session

10. [ ] Frontend: Testing and quality
    - [ ] Add unit tests for token interceptor and auth guard
    - [ ] Add component tests for critical pages (e.g., profile)
    - [ ] Configure ESLint with Angular recommended rules and Prettier for formatting
    - [ ] Set up basic e2e tests (Cypress or Playwright) for auth flow and protected routes

11. [ ] API contract and client integration
    - [ ] Define API spec via OpenAPI and generate typed client for the frontend
    - [ ] Add automated drift checks between backend and frontend contracts

12. [ ] DevOps: Containerization and local dev
    - [ ] Add Dockerfile for backend service (multi-stage build)
    - [ ] Add Dockerfile for frontend (build + nginx serve) or use Angular SSR strategy if needed
    - [ ] Extend docker-compose to include backend and frontend services; add service healthchecks
    - [ ] Parameterize compose via .env and document local development workflow

13. [ ] CI/CD pipeline
    - [ ] Configure CI (GitHub Actions/GitLab CI): build, test, lint for backend and frontend
    - [ ] Upload Jacoco/coverage reports and lint results; enforce quality gates
    - [ ] Cache dependencies (Maven, npm) to speed up builds
    - [ ] Add security scans (OWASP Dependency-Check, Snyk, or Dependabot) and Docker image scanning
    - [ ] Add preview deployments or at least artifact publishing

14. [ ] Security posture
    - [ ] Verify Keycloak realm import: clients, roles, mappers, token claims, and lifetimes
    - [ ] Ensure HTTPS and secure cookies for production deployments; document reverse proxy setup
    - [ ] Add rate limiting and basic DoS protections (at gateway or filter)
    - [ ] Review CORS policy and narrow to trusted domains per environment

15. [ ] Documentation
    - [ ] Create a top-level README outlining architecture, services, and how to run locally
    - [ ] Document environment variables, profiles, and secrets management
    - [ ] Add runbooks: local dev, testing, migration, and troubleshooting
    - [ ] Provide architectural diagrams (C4 model: Context, Container, Component)

16. [ ] Release and environments
    - [ ] Define environments (dev, staging, prod) with configuration per environment
    - [ ] Add database backup/restore procedures and data migration guidance
    - [ ] Create a rollback strategy for application and DB

17. [ ] Performance and resilience
    - [ ] Add timeouts, circuit breakers, and retries for outbound calls (if/when present)
    - [ ] Enable GZIP/HTTP compression and caching headers where appropriate
    - [ ] Add load test scripts (k6 or Gatling) for critical flows

18. [ ] Housekeeping
    - [ ] Remove unused imports and dependencies (backend and frontend)
    - [ ] Standardize formatting (Spotless/Formatter Maven plugin for Java; Prettier for TS/HTML/SCSS)
    - [ ] Ensure licenses and notices for third-party dependencies

19. [ ] Monitoring and alerting (prod readiness)
    - [ ] Wire Prometheus scraping and basic Grafana dashboards
    - [ ] Expose and alert on key SLOs (availability, latency, error rate)
    - [ ] Add log aggregation guidance (ELK/Opensearch or cloud-native)

20. [ ] Future architecture considerations
    - [ ] Evaluate modularization or hexagonal architecture as domain grows
    - [ ] Consider API gateway and service decomposition if multiple bounded contexts emerge
    - [ ] Plan for blue/green or canary deployments in CI/CD
