package ar.edu.unlam.mobile.androidbase.domain.kitty.services

import ar.edu.unlam.mobile.androidbase.data.kitty.repository.KittyRepository
import ar.edu.unlam.mobile.androidbase.domain.kitty.models.Kitty
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewKitty @Inject constructor(var repo: KittyRepository) : KittyUseCase {
    override fun getKitty(): Flow<Kitty> {
        return this.repo.getKitty()
    }
}
