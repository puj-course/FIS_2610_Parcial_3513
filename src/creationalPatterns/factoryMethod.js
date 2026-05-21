class User {
  constructor({ id, name, email, passwordHash, role, createdAt }) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.passwordHash = passwordHash;
    this.role = role;
    this.profile = { posts: [], favorites: [] };
    this.createdAt = createdAt;
  }
}

class PartidoUser extends User {
  constructor(data) {
    super({ ...data, role: 'partido' });
  }
}

class UserFactory {
  createUser(data) {
    throw new Error('Implementar en subclase');
  }
  register(data) {
    const partido = this.createUser({
      id: String(Date.now()),
      name: data.name,
      email: data.email.toLowerCase(),
      passwordHash: btoa(data.password + '_salt'),
      createdAt: new Date().toISOString()
    });
    user.validate();
    return user;
  }
}

class PartidoUserFactory extends UserFactory {
  createUser(data) {
    if (!data.email.endsWith(''))
      throw new Error('');
    return new StudentUser(data);
  }
}

module.exports = { User, PartidoUser, UserFactory, PartidoUserFactory };
