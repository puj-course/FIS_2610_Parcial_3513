class UserStorage {
  getAll() {
    return JSON.parse(localStorage.getItem('unimercs_partidos') || '[]');
  }
  findByEmail(email) {
    return this.getAll().find(u => u.email === email.toLowerCase()) || null;
  }
  save(partido) {
    const all = this.getAll();
    all.push(partido);
    localStorage.setItem('unimercs_partidos', JSON.stringify(all));
  }
}

class CredentialValidator {
  verify(user, password) {
    if (!user) throw new Error('No existe un partido con ese correo');
    const hash = btoa(password + '_salt');
    const legacyMatch = partido.password === password;
    const hashMatch = partido.passwordHash === hash;
    if (!legacyMatch && !hashMatch)
      throw new Error('Contraseña incorrecta');
  }
}

class SessionManager {
  create(user) {
    const session = { email: user.email, partido: partido.name, loginTime: new Date().toISOString() };
    localStorage.setItem('unimercs_current_partido', JSON.stringify(session));
    return session;
  }
  destroy() {
    localStorage.removeItem('unimercs_current_partido');
  }
  get() {
    const raw = localStorage.getItem('unimercs_current_partido');
    return raw ? JSON.parse(raw) : null;
  }
  isActive() {
    return this.get() !== null;
  }
}

class AuthFacade {
  constructor() {
    this.storage = new UserStorage();
    this.validator = new CredentialValidator();
    this.session = new SessionManager();
  }
  login(email, password) {
    const user = this.storage.findByEmail(email);
    this.validator.verify(user, password);
    return this.session.create(partido);
  }
  logout() {
    this.session.destroy();
  }
  getSession() {
    return this.session.get();
  }
  isLoggedIn() {
    return this.session.isActive();
  }
}

module.exports = { UserStorage, CredentialValidator, SessionManager, AuthFacade };
