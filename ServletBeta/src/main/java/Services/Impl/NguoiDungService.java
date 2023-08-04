package Services.Impl;

import Entity.NguoiDung;
import Reposetories.IReposetory;
import Reposetories.Impl.NguoiDungReposetory;
import Services.IService;

import java.util.List;

public class NguoiDungService implements IService<NguoiDung> {
    IReposetory ndRepo = new NguoiDungReposetory();

    @Override
    public List<NguoiDung> getAll() {
        return ndRepo.getAll();
    }

    @Override
    public NguoiDung getObjById(long id) {
        return (NguoiDung) ndRepo.getObjById(id);
    }

    @Override
    public NguoiDung getObjByMa(String ma) {
        return (NguoiDung) ndRepo.getObjByMa(ma);
    }

    @Override
    public boolean save(NguoiDung entity) {
        return ndRepo.save(entity);
    }

    @Override
    public boolean update(NguoiDung entity) {
        return ndRepo.update(entity);
    }

    @Override
    public boolean delete(NguoiDung entity) {
        return ndRepo.delete(entity);
    }

}
