import { TestBed } from '@angular/core/testing';

import { LogService } from './service/log.service';

describe('LogService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LogService = TestBed.get(LogService);
    expect(service).toBeTruthy();
  });
});
