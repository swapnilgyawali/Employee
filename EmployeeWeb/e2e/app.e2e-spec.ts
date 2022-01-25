import { SodaMachinePage } from './app.po';

describe('soda-machine App', () => {
  let page: SodaMachinePage;

  beforeEach(() => {
    page = new SodaMachinePage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
