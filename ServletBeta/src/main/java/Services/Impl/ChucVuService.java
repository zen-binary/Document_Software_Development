package Services.Impl;

import Entity.ChucVu;
import Reposetories.IReposetory;
import Reposetories.Impl.ChucVuReposetory;
import Services.IService;

import java.util.List;

public class ChucVuService implements IService<ChucVu> {
    IReposetory cvRepo = new ChucVuReposetory();

    @Override
    public List<ChucVu> getAll() {
        return cvRepo.getAll();
    }

    @Override
    public ChucVu getObjById(long id) {
        return (ChucVu) cvRepo.getObjById(id);
    }

    @Override
    public ChucVu getObjByMa(String ma) {
        return (ChucVu) cvRepo.getObjByMa(ma);
    }

    @Override
    public boolean save(ChucVu entity) {
        return cvRepo.save(entity);
    }

    @Override
    public boolean update(ChucVu entity) {
        return cvRepo.update(entity);
    }

    @Override
    public boolean delete(ChucVu entity) {
        return cvRepo.delete(entity);
    }
}
