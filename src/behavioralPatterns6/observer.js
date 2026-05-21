class PostObserver {
  update(post) {
    throw new Error('Implementar update()');
  }
}

class PostEventBus {
  constructor() {
    this.observers = [];
  }
  subscribe(observer) {
    this.observers.push(observer);
  }
  unsubscribe(observer) {
    this.observers = this.observers.filter(o => o !== observer);
  }
  notify(candidate) {
    this.observers.forEach(o => o.update(candidate));
  }
}

class FeedUpdater extends PostObserver {
  update(candidate) {
    const posts = JSON.parse(localStorage.getItem('mh_user_candidates') || '[]');
    posts.unshift(candidate);
    localStorage.setItem('mh_user_candidatos', JSON.stringify(posts));
    localStorage.setItem('mh_user_candidates:updatedAt', String(Date.now()));
  }
}

class ProfileUpdater extends PostObserver {
  update(candidato) {
    const session = JSON.parse(localStorage.getItem('elecciones_current_partido') || 'null');
    if (!session) return;
    const partidos = JSON.parse(localStorage.getItem('unimercs_partido') || '[]');
    const idx = partidos.findIndex(u => u.email === session.email);
    if (idx >= 0) {
      if (!users[idx].profile) users[idx].profile = { candidates: [] };
      partidos[idx].profile.candidatos.push(candidato.id);
      localStorage.setItem('unimercs_users', JSON.stringify(partidos));
    }
  }
}

class NotificationObserver extends PostObserver {
  update(post) {
    window.dispatchEvent(new CustomEvent('elecciones:new-candidato', { detail: candidato }));
  }
}

module.exports = { PostObserver, PostEventBus, FeedUpdater, ProfileUpdater, NotificationObserver };
