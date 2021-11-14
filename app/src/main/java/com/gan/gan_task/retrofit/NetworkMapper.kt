package com.gan.gan_task.retrofit

import com.gan.gan_task.model.BBCharacter
import com.gan.gan_task.util.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor(): EntityMapper<BBCharacterNetworkEntity,BBCharacter> {
    override fun mapFromEntity(entity: BBCharacterNetworkEntity): BBCharacter {
        return BBCharacter(char_id = entity.char_id,
        name = entity.name,
        birthday = entity.birthday,
        occupation = entity.occupation,
        img = entity.img,
        status = entity.status,
        nickname = entity.nickname,
        portrayed = entity.portrayed,
        appearance = entity.appearance,
        category = entity.category,
        better_call_saul_appearance = entity.better_call_saul_appearance)
    }

    override fun mapToEntity(domainModel: BBCharacter): BBCharacterNetworkEntity {
        return BBCharacterNetworkEntity(char_id = domainModel.char_id,
            name = domainModel.name,
            birthday = domainModel.birthday,
            occupation = domainModel.occupation,
            img = domainModel.img,
            status = domainModel.status,
            nickname = domainModel.nickname,
            portrayed = domainModel.portrayed,
            appearance = domainModel.appearance,
            category = domainModel.category,
        better_call_saul_appearance = domainModel.better_call_saul_appearance)
    }

    fun mapFromNetworkEntityList(entities : List<BBCharacterNetworkEntity>): List<BBCharacter>{
        return entities.map { mapFromEntity(it) }
    }
}